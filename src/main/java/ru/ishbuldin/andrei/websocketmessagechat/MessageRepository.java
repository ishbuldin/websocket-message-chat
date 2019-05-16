package ru.ishbuldin.andrei.websocketmessagechat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    List<Message> findBySender(String sender);
    List<Message> findAll();
    Page<Message> findAll(Pageable pageable);

}