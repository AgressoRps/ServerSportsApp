package org.communis.serversportsapp.dto;

import java.io.Serializable;

public interface ObjectWrapper<T> extends Serializable {

    /**
     * Добавление объекта Entity в объект EntityNameWrapper
     * @param item - экземпляр объекта Entity
     */
    void toWrapper(T item);

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта Entity, содержит только допустимые для отправки данные
     */
    void fromWrapper(T item);
}
