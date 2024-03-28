package com.poluectov.rvproject.controller.crud;

import com.poluectov.rvproject.dto.message.MessageRequestTo;
import com.poluectov.rvproject.dto.message.MessageResponseTo;
import com.poluectov.rvproject.model.Message;
import com.poluectov.rvproject.service.CommonRestService;
import com.poluectov.rvproject.utils.modelassembler.MessageModelAssembler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/messages")
public class MessageController extends CommonRESTController<Message, MessageRequestTo, MessageResponseTo> {
    public MessageController(CommonRestService<Message, MessageRequestTo, MessageResponseTo> service,
                             MessageModelAssembler assembler) {
        super(service, assembler::toModel);
    }

}
