package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.ProgressWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/progress")
public class ProgressRestController {

    private final ProgressService progressService;

    @Autowired
    public ProgressRestController(ProgressService progressService){
        this.progressService = progressService;
    }

    /**
     * Метод реагирует на запрос /progress/add, выполняет запрос к бд
     * для добавления нового достижения
     * @param progressWrapper данные достижения, которые необходимо добавить в бд
     * @return true - при успешном добавлении в бд
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addProgress(ProgressWrapper progressWrapper) throws ServerException{
        return progressService.addProgress(progressWrapper);
    }

    /**
     * Метод реагирует на запрос /progress/edit, выполняет запрос к бд для
     * обновления данных указанного достижения
     * @param progressWrapper содержит новые данные достижения
     * @return true - при успешном обновлении данных
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public String editProgress(ProgressWrapper progressWrapper) throws ServerException{
        return progressService.editProgress(progressWrapper);
    }

    /**
     * Метод реагирует на запрос /progress/delete, выполняет запрос к бд для
     * удаления достижения
     * @param progressWrapper содержит идентификатор, по которому будет удалено соответствующее достижение
     * @return true - при успешном удалении из базы данных
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProgress(ProgressWrapper progressWrapper) throws ServerException{
        return progressService.deleteProgress(progressWrapper);
    }
}
