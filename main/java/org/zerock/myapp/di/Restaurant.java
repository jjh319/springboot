package org.zerock.myapp.di;


import jakarta.annotation.Resource;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Log4j2
//@Data


@Component
public class Restaurant implements InitializingBean, DisposableBean {  // POJO

//    @Setter(onMethod_ = { @Autowired })
    @Setter(onMethod_ = { @Resource(type = Chef.class) })
//    @Resource
//    @Resource(type = Chef.class)
//    @Autowired
    private Chef chef;

    @Override
    public void destroy() throws Exception {
        log.trace("destroy() invoked.");
    } // destroy

    @Override
    public void afterPropertiesSet() throws Exception {
        log.trace("afterPropertiesSet() invoked.");

        Objects.requireNonNull(this.chef);
        log.info("\t this.chef: {}", this.chef);
    } // afterPropertiesSet


//    public Restaurant(Chef chef) {
//        log.trace("Constructor({}) invoked.", chef);
//
//        this.chef = chef;
//    } // Constructor



//    @Autowired
//    public void setChef(Chef chef) {
//        this.chef = chef;
//    } // setChef



} // end class
