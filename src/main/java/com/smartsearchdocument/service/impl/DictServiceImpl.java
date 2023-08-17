package com.smartsearchdocument.service.impl;


import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.domain.Dict;
import com.smartsearchdocument.dos.DictDO;
import com.smartsearchdocument.dos.DictItemDO;
import com.smartsearchdocument.dto.command.SaveDictCommand;
import com.smartsearchdocument.dto.query.DictPaging;
import com.smartsearchdocument.repo.DictRepo;
import com.smartsearchdocument.repo.dynamic.DictDynamicDao;
import com.smartsearchdocument.service.DictItemService;
import com.smartsearchdocument.service.DictService;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 字典表ServiceImpl
 *
Dict
 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class DictServiceImpl implements DictService {

    private final DictRepo dictRepo;
    private final DictDynamicDao dictDynamicDao;
    private final DictItemService dictItemService;

    @Override
    public DictDO addDict(SaveDictCommand saveDictCommand) {

        dictRepo.findByName(saveDictCommand.getName())
                .filter(DOBase::getNotDel)
                .ifPresent(dictDO -> {
                    throw Ex.of("字典名已存在");
                });

        DictDO dictDO = saveDictCommand.to();
        return dictRepo.save(dictDO);
    }

    @Override
    public DictDO updateDict(String id, SaveDictCommand saveDictCommand) {

        DictDO dictDO = getDictById(id);
        DictDO dictDONew = saveDictCommand.update(dictDO);
        return dictRepo.save(dictDONew);
    }


    @Override
    public DictDO getDictById(String id) {

        return dictRepo.findById(id)
                       .filter(DOBase::getNotDel)
                       .orElseThrow(() -> Ex.of("字典不存在"));
    }


    @Override
    public Page<DictDO> dictPaging(DictPaging dictPaging, Pageable pageable) {

        return dictDynamicDao.dictPaging(dictPaging, pageable);
    }

    @Override
    public void delDict(String id) {

        DictDO dictDO = getDictById(id);
        dictDO.setNotDel(false);
        dictRepo.save(dictDO);
    }

    @Override
    public List<DictItemDO> getAllDictItemsById(String id) {

        return dictRepo.findById(id)
                       .filter(DOBase::getNotDel)
                       .map(dictDO -> dictItemService.getByDictId(dictDO.getId()))
                       .orElse(new ArrayList<>());
    }

    @Override
    public Dict getDictByType(String type) {

        return dictRepo.findByType(type)
                .filter(DOBase::getNotDel)
                .map(dictDO -> {

                    List<DictItemDO> dictItemDOList = dictItemService.getByDictId(dictDO.getId());

                    return Dict.form(dictDO, dictItemDOList);
                })
                .orElse(null);

    }

}
