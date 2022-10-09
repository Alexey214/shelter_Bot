package service.impl;

import model.BotResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import repository.BotResponseRepository;
import service.BotResponseService;

@Service
public class BotResponseServiceImpl implements BotResponseService {

    private final Logger logger = LoggerFactory.getLogger(BotResponseServiceImpl.class);

    private final BotResponseRepository responseRepositoryepository;

    public BotResponseServiceImpl(BotResponseRepository shelterRepository) {
        this.responseRepositoryepository = shelterRepository;
    }

    public String getResponseMessage(String message) {
        logger.info("Пробем получить ответ на вопрос \"" + message + "\"");

        BotResponse response = responseRepositoryepository.findBotResponseByKeyMessage(message);
        if (response == null) {
            logger.info("Ответ не найден");
            return null;
        }

        logger.info("Ответ найден");
        return response.getResponseMessage();
    }

    public BotResponse saveResponseMessage(String keyMessage, String responseMessage) {
        logger.info(" сохраненяем ключ-запрос " + keyMessage + " и ответ " + responseMessage);

        return responseRepositoryepository.save(new BotResponse(keyMessage, responseMessage));
    }
}
