package com.smartsearchdocument.service.impl;


import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dos.DictItemDO;
import com.smartsearchdocument.dto.command.SaveDictItemCommand;
import com.smartsearchdocument.repo.DictItemRepo;
import com.smartsearchdocument.service.DictItemService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 字典项ServiceImpl
 *
 * @author NotEdibleSalt
DictItem
 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class DictItemServiceImpl implements DictItemService {

    private final DictItemRepo dictItemRepo;

    @Override
    public DictItemDO addDictItem(SaveDictItemCommand saveDictItemCommand) {

        dictItemRepo.findByLabel(saveDictItemCommand.getLabel())
                    .filter(DOBase::getNotDel)
                    .ifPresent(dictItemDO -> {
                        throw Ex.of("角色名已存在");
                    });

        DictItemDO dictItemDO = saveDictItemCommand.to();
        return dictItemRepo.save(dictItemDO);
    }

    @Override
    public DictItemDO updateDictItem(String id, SaveDictItemCommand saveDictItemCommand) {

        DictItemDO dictItemDO = getDictItemById(id);
        DictItemDO dictItemDONew = saveDictItemCommand.update(dictItemDO);
        return dictItemRepo.save(dictItemDONew);
    }


    @Override
    public DictItemDO getDictItemById(String id) {

        return dictItemRepo.findById(id)
                           .filter(DOBase::getNotDel)
                           .orElseThrow(() -> Ex.of("字典项不存在"));
    }


    @Override
    public void delDictItem(String id) {

        DictItemDO dictItemDO = getDictItemById(id);
        dictItemDO.setNotDel(false);
        dictItemRepo.save(dictItemDO);
    }

    @Override
    public List<DictItemDO> getByDictId(String dictId) {

        return dictItemRepo.findByDictId(dictId)
                           .stream()
                           .filter(DOBase::getNotDel)
                           .collect(Collectors.toList());
    }
}
