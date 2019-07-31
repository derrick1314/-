package cn.itsource.pwc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandServiceTest {

    @Autowired
    private IBrandService brandService;

    @Test
    public void test(){
        brandService.list().forEach(e-> System.out.println(e));
    }
}