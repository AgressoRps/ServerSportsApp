package org.communis.serversportsapp.controller.view;


import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.ProgressWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService progressService;

    @Autowired
    public ProgressController(ProgressService progressService){
        this.progressService = progressService;
    }

    /**
     * Метод реагирует на запрос /progress, выполняет запрос к бд для получения списка всех достижений
     * @return список экземпляров класса ProgressWrapper (список достижений)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ProgressWrapper> getAllProgress() throws ServerException{
        return progressService.getAllProgress();
    }

    /**
     * Метод реагирует на запрос /progress/{id}, выполняет запрос к бд для получения одного достижения
     * по переданному идентификатору
     * @param id идентификатор требуемого достижения
     * @return экземпляр класса ProgressWrapper (содержит данные достижения)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProgressWrapper getById(@PathVariable("id") Short id) throws ServerException{
        return progressService.getById(id);
    }
}
