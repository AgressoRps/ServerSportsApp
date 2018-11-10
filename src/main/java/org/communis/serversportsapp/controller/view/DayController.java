package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.DayWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.repository.DayRepository;
import org.communis.serversportsapp.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/day")
public class DayController {

    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService){
        this.dayService = dayService;
    }

    /**
     * Метод реагирует на запрос /day, выполняет запрос к бд для получения списка всех дней
     * @return список экземпляров DayWrapper
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<DayWrapper> getAllDays() throws ServerException{
        return dayService.getAllDays();
    }

    /**
     * Метод реагирует на запрос /day/{id}, выполняет запрос к бд для получения дня по переданному идентификатору
     * @param id идентификатор запрашиваемого дня
     * @return экземпляр класса Day
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DayWrapper getDayById(@PathVariable("id") Short id) throws ServerException{
        return dayService.getById(id);
    }

}
