package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.DayWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/day")
public class DayRestController {

    private final DayService dayService;

    @Autowired
    public DayRestController(DayService dayService){
        this.dayService = dayService;
    }

    /**
     * Метод реагирует на post запрос /day/add, выполняет запрос к бд
     * для добавления нового дня
     * @param dayWrapper содержит данные, которые необходимо добавить
     * @return true - в случае успешного добавления
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addDay(DayWrapper dayWrapper) throws ServerException{
        return dayService.addDay(dayWrapper);
    }

    /**
     * Метод реагирует на patch запрос /day/edit, выполняет запрос к бд
     * для редактирования указанного дня
     * @param dayWrapper содержит данные, которые необходимо изменить
     * @return true - в случае успешного изменения
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public String editDay(DayWrapper dayWrapper) throws ServerException{
        return dayService.editDay(dayWrapper);
    }

    /**
     * Метод реагирует на запрос /day/delete, выполняет запрос к бд
     * для удаления дня по переданному идентификатору
     * @param dayWrapper содержит идентификатор, по которому выполняется удаление
     * @return true - в случае успешного удаления
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteDay(DayWrapper dayWrapper) throws ServerException{
        return dayService.deleteDay(dayWrapper.getId());
    }
}
