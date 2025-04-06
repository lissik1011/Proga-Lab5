package collection_manager;
import java.util.Queue;

import data.LabWork;

public class CollectionManager{
    LabWork labwork;

    public CollectionManager(LabWork labwork){
        this.labwork = labwork;
    }

    // Мне нужна проверка для того, чтобы еще и указать пользователю, какие именно данные у него неверны. Или просто сказать,
    // что данные неверные. Я же хочу сделать 2 input, первый будет добавлять все верные данные, выводить ошибку о не добавленных,
    // второй проще - будет тупо ничего не добавлять, если что то из этого неверно. Но тогда придется организовывать 
    // еще одно место хранения... Или использовать транзакции, если такоевые имеются.

    public String validation(Queue collection){
        if (labwork.validate()){
            collection.add(labwork);
        }
        else{
            return String.format("Невалидные данные: %s", labwork);
        }

        return "Успешно добавлено";
    }
}