package com.smartsearchdocument.domain;

import com.smartsearchdocument.dos.DictDO;
import com.smartsearchdocument.dos.DictItemDO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Data;

/**
 * @author NotEdibleSalt

 */
@Data
public class Dict implements Serializable {

    private String id;
    private String name;
    private String type;
    private List<Map<String, Object>> items;

    public static Dict form(DictDO dictDO, List<DictItemDO> dictItemDOList) {

        Dict dict = new Dict();
        dict.setId(dictDO.getId());
        dict.setName(dictDO.getName());
        dict.setType(dictDO.getType());

        List<Map<String, Object>> mapList = dictItemDOList.stream()
                                                          .map(dictItemDO -> {

                                                              Map<String, Object> map = new HashMap<>();
                                                              map.put("id", dictItemDO.getId());
                                                              map.put("label", dictItemDO.getLabel());
                                                              map.put("value", dictItemDO.getValue());

                                                              return map;
                                                          })
                                                          .collect(Collectors.toList());

        dict.setItems(mapList);

        return dict;
    }


}
