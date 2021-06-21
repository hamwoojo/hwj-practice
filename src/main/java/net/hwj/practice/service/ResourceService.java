package net.hwj.practice.service;


import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class ResourceService {
    @Autowired
    ResourceRepository resourceRepository;


}
