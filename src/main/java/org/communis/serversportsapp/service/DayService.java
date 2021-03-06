package org.communis.serversportsapp.service;

import com.sun.prism.impl.shape.ShapeRasterizer;
import org.communis.serversportsapp.dto.DayWrapper;
import org.communis.serversportsapp.entity.Day;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformation;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NameNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class DayService {

    private final DayRepository dayRepository;

    @Autowired
    public DayService(DayRepository dayRepository){
        this.dayRepository = dayRepository;
    }

    /**
     * Метод получения списка всех дней из базы данных
     * @return список объектов DayWrapper
     * @throws ServerException генерирует исключение с кодом DAY_LIST_ERROR
     */
    public List<DayWrapper> getAllDays() throws ServerException {
        try {
            return dayRepository.findAll().stream().map(DayWrapper::new).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DAY_LIST_ERROR), ex);
        }
    }

    /**
     * Метод получения дня по идентификатору
     * @param id идентификатор дня
     * @return экземпляр класса DayWrapper
     * @throws ServerException генерирует исключение с кодом DAY_INFO_ERROR
     */
    public DayWrapper getById(Short id) throws ServerException{
        try {
            return new DayWrapper(getDay(id));
        } catch (ServerException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DAY_INFO_ERROR), ex);
        }
    }

    /**
     * Внутренний метод для получения экземпляра класса Day с данными из бд
     * @param id идентификатор дня
     * @return экземпляр класса Day
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private Day getDay(Short id) throws ServerException {
        return dayRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

    /**
     * Метод добавления дня в базу данных
     * @param dayWrapper полученные данные (день)
     * @return при успешном выполнении - true
     * @throws ServerException генерирует исключение с кодом DAY_ADD_ERROR либо DATA_VALIDATE_ERROR
     */
    public String addDay(DayWrapper dayWrapper) throws ServerException{
        try {
            if (dayWrapper.getName() != null && !dayWrapper.getName().equals("")) {
                Day day = new Day();
                dayWrapper.fromWrapper(day);
                dayRepository.save(day);
                return "true";
            }
            else{
                throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
            }
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DAY_ADD_ERROR), ex);
        }
    }

    /**
     * Метод редактирования дня
     * @param dayWrapper данные, которые нужно редактировать (день)
     * @return в случае успешного выполнения - true
     * @throws ServerException метод генерирует исключение с кодом DAY_UPDATE_ERROR
     */
    public String editDay(DayWrapper dayWrapper) throws ServerException{
        try{
            Day day = getDay(dayWrapper.getId());
            dayWrapper.fromWrapper(day);
            dayRepository.save(day);
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DAY_UPDATE_ERROR), ex);
        }
    }

    /**
     * Метод удаления дня
     * @param dayWrapper содержит идентификатор, по которому будет производится удаление
     * @return в случае успешного выполнения - true
     * @throws ServerException метод генерирует исключение с кодом DAY_DELETE_ERROR
     */
    public String deleteDay(DayWrapper dayWrapper) throws ServerException{
        try {
            Day day = new Day();
            dayWrapper.fromWrapper(day);
            dayRepository.delete(day);
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DAY_DELETE_ERROR), ex);
        }
    }
}
