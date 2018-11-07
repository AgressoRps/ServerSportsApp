package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.LevelDifficulty;

import java.io.Serializable;

@Data
public class LevelDifficultyWrapper implements ObjectWrapper<LevelDifficulty>, Serializable {

    private Short id;
    private String name;
    private Short time;
    private Float coefficient;

    public LevelDifficultyWrapper(LevelDifficulty levelDifficulty){
        toWrapper(levelDifficulty);
    }

    /**
     * Добавление данных объекта LevelDifficulty в объект LevelDifficultyWrapper
     * @param item - экземпляр объекта LevelDifficulty
     */
    @Override
    public void toWrapper(LevelDifficulty item) {
        if (item != null){
            id = item.getId();
            name = item.getName();
            time = item.getTime();
            coefficient = item.getCoefficient();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта LevelDifficulty, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(LevelDifficulty item) {
        if (item != null){
            item.setId(id);
            item.setName(name);
            item.setTime(time);
            item.setCoefficient(coefficient);
        }
    }
}
