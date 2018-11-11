package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.StatisticsWrapper;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService){
        this.statisticsService = statisticsService;
    }

    /**
     * Метод реагирует на запрос /statistics/user/{id}, выполняет запрос к бд для получения
     * всей статистики указанного пользователя
     * @param id идентификатор пользователя, статистику которого необходимо получить
     * @return список экземпляров класса StatisticsWrapper (список всей статистики пользователя)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public List<StatisticsWrapper> getAllStatisticsByUser(@PathVariable("id") Long id) throws ServerException{
        return statisticsService.getAllStatisticsByUser(id);
    }

    /**
     * Метод реагирует на запрос /statistics/user/{userId}/location/{locationId}, выполняет запрос к бд
     * для получения статистики указанного пользователя по переданной локации
     * @param userId идентификатор пользователя
     * @param locationId идентификатор локации
     * @return список экземпляров класса StatisticsWrapper (список статистики)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/user/{userId}/location/{locationId}", method = RequestMethod.GET)
    public List<StatisticsWrapper> getAllByUserIdAndLocationId(@PathVariable("userId") Long userId,
                                                               @PathVariable("locationId") Short locationId) throws ServerException{
        return statisticsService.getByUserIdAndLocationId(userId, locationId);
    }

    /**
     * Метод реагирует на запрос /statistics/user/{userId}/program/{programId}, выполняет запрос к бд
     * для получения статистики указанного пользователя по переданной тренировочной программе
     * @param userId идентификатор пользователя
     * @param programId идентификатор тренировчной программы
     * @return список экземпляров класса StatisticsWrapper (список статистики)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/user/{userId}/program/{programId}", method = RequestMethod.GET)
    public List<StatisticsWrapper> getAllByUserIdAndProgramId(@PathVariable("userId") Long userId,
                                                              @PathVariable("programId") Long programId) throws ServerException{
        return statisticsService.getByUserIdAndProgramId(userId, programId);
    }

    /**
     * Метод реагирует на запрос /statistics/user/{id}/day/{trainingDayId}, выполняет запрос к бд
     * для получения статистики указанного пользователя по переданному тренировочному дню
     * @param userId идентификатор пользователя
     * @param trainingDayId идентификатор тренировочного дня
     * @return экземпляр класса StatisticsWrapper (статистика)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/user/{id}/day/{trainingDayId}", method = RequestMethod.GET)
    public StatisticsWrapper getByUserIdAndTrainingDayId(@PathVariable("id") Long userId,
                                                         @PathVariable("trainingDayId") Long trainingDayId) throws ServerException{
        return statisticsService.getByUserIdAndDayId(userId, trainingDayId);
    }

    /**
     * Метод реагирует на запрос /{id}, выполняет запроса к бд для получения статистики
     * по переданному идентификатору
     * @param id идентификатор пользователя
     * @return экземпляр класса StatisticsWrapper (статистика)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StatisticsWrapper getById(@PathVariable("id") Long id) throws ServerException{
        return statisticsService.getById(id);
    }
}
