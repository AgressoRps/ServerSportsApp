package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Day;

import java.io.Serializable;

@Data
public class DayWrapper implements ObjectWrapper<Day>, Serializable {

    private Short id;
    private String name;

    public DayWrapper(Day day){
        toWrapper(day);
    }

    @Override
    public void toWrapper(Day item) {
        if (item != null){
            id = item.getId();
            name = item.getName();
        }
    }

    @Override
    public void fromWrapper(Day item) {
        if (item != null){
            item.setId(id);
            item.setName(name);
        }
    }
}
