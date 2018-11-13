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
    public String add(DayWrapper dayWrapper) throws ServerException{
        return dayService.addDay(dayWrapper);
    }
}
