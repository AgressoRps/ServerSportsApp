package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.ProgressWrapper;
import org.communis.serversportsapp.entity.Progress;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class ProgressService {

    private final ProgressRepository progressRepository;

    @Autowired
    public ProgressService(ProgressRepository progressRepository){
        this.progressRepository = progressRepository;
    }

    /**
     * Метод поиска и получения всех достижений
     * @return список экземпляров класса ProgressWrapper (список достижений)
     * @throws ServerException генерирует исключение с кодом PROGRESS_LIST_ERROR
     */
    public List<ProgressWrapper> getAllProgress() throws ServerException{
        try {
            return progressRepository.findAll().stream().map(ProgressWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.PROGRESS_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения достижения по указанному идентификатору
     * @param id идентификатор достижения
     * @return экземпляр класса ProgressWrapper с данными о достижении
     * @throws ServerException генерирует исключение с кодом PROGRESS_INFO_ERROR
     */
    public ProgressWrapper getById(Short id) throws ServerException{
        try {
            return new ProgressWrapper(getProgress(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.PROGRESS_INFO_ERROR), ex);
        }
    }

    /**
     * Метод получения достижения по указанному идентификатору
     * @param id идентификатор достижения
     * @return экземпляр класса Progress с данными о достижении
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private Progress getProgress(Short id) throws ServerException{
        return progressRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

}
