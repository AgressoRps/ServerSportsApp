package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.StatisticsWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/statistics")
public class StatisticsRestController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsRestController(StatisticsService statisticsService){
        this.statisticsService = statisticsService;
    }

    /**
     * Метод реагирует на запрос /statistics/add, выполняет запрос к бд
     * для добавления статистики пользователя
     * @param statisticsWrapper статистика пользователя, которую необходимо добавить в бд
     * @return true - при успешном выполнении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addStatistics(StatisticsWrapper statisticsWrapper) throws ServerException{
        return statisticsService.addStatistics(statisticsWrapper);
    }

    /**
     * Метод реагирует на запрос /statistics/delete, выполняет запрос к бд
     * для удаления статистики пользователя
     * @param statisticsWrapper содержит идентификатор, по которому будет удалена соответствующая запись
     * @return true - при успешном удалении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteStatistics(StatisticsWrapper statisticsWrapper) throws ServerException{
        return statisticsService.deleteStatistics(statisticsWrapper);
    }

}
