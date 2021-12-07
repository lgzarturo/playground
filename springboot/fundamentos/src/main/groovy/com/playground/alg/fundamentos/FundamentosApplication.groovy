package com.playground.alg.fundamentos

import com.playground.alg.fundamentos.bean.BeanWithOperationDependency
import com.playground.alg.fundamentos.bean.BeanWithPropertiesDependency
import com.playground.alg.fundamentos.bean.UnBeanDependency
import com.playground.alg.fundamentos.component.ComponentDependency
import com.playground.alg.fundamentos.model.User
import com.playground.alg.fundamentos.pojo.WebserviceProperties
import com.playground.alg.fundamentos.repository.UserRepository
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.joda.time.Days
import org.joda.time.DurationFieldType
import org.joda.time.LocalDate
import org.joda.time.Period
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.domain.Sort

@SpringBootApplication
class FundamentosApplication implements CommandLineRunner {

    private Log log = LogFactory.getLog(this.class)

    private UnBeanDependency unBeanDependency
    private ComponentDependency componentDependency
    private BeanWithOperationDependency beanWithOperationDependency
    private BeanWithPropertiesDependency beanWithPropertiesDependency
    private WebserviceProperties webserviceProperties
    private UserRepository userRepository

    /**
     * @Qualifier indica el nombre de la dependencia que se quiere inyectar
     * @param componentDependency
     */
    FundamentosApplication(@Qualifier("component2Implement") ComponentDependency componentDependency,
                           UnBeanDependency unBeanDependency,
                           BeanWithOperationDependency beanWithOperationDependency,
                           BeanWithPropertiesDependency beanWithPropertiesDependency,
                           WebserviceProperties webserviceProperties,
                           UserRepository userRepository) {
        this.componentDependency = componentDependency
        this.unBeanDependency = unBeanDependency
        this.beanWithOperationDependency = beanWithOperationDependency
        this.beanWithPropertiesDependency = beanWithPropertiesDependency
        this.webserviceProperties = webserviceProperties
        this.userRepository = userRepository
    }

    static void main(String[] args) {
		SpringApplication.run(FundamentosApplication, args)
	}

    @Override
    void run(String... args) throws Exception {
        getDaysBetweenDates()

        /*dependencyExamples()
        saveUsers()
        getInformationFromUser("lgzarturo_6@gmail.com")
        getInformationFromUser("lgzarturo_99@gmail.com")
        getAllUsers()
        getOneUser()*/
    }

    private void saveUsers() {
        def users = []
        (1..10).each {
            users << new User(
                username: "lgzarturo_${it}",
                email: "lgzarturo_${it}@gmail.com",
                password: '12345',
                birthDate: LocalDate.of(2021, 10, 29)
            )
        }
        users.forEach(userRepository::save)
    }

    private getInformationFromUser(String username) {
        def user = userRepository.findByEmailString(username)
        if (user.isPresent()){
            log.info("El usuario es: ${username} : ${user.get()}")
        } else {
            log.error("No se pudo localizar al usuario")
        }
    }

    private getAllUsers() {
        userRepository.findAndSort("lgz", Sort.by("id").descending())
            .stream().forEach(log::info)
    }

    private getOneUser() {
        log.info("Obteniendo un solo usuario")
        userRepository.findByUsername("lgzarturo_1").stream().forEach(log::info)
    }

    private void dependencyExamples() {
        componentDependency.greetings()
        unBeanDependency.printAction()
        beanWithOperationDependency.printWithDependency()
        println(beanWithPropertiesDependency.function())
        println(webserviceProperties.toString())
        log.error("Este es un error en la aplicación")
    }

    private void getDaysBetweenDates() {
        def checkin = new LocalDate(2021, 12, 24)
        def checkout = new LocalDate(2021, 12, 27)
        def days = Days.daysBetween(checkin, checkout).days
        def periodDays = Period.fieldDifference(checkin, checkout).get(DurationFieldType.days())
        def period = new Period(checkin, checkout)
        log.info("Days 24-27 between dates: ${days} ${periodDays} ${period.days}")
        checkout = new LocalDate(2021, 12, 28)
        days = Days.daysBetween(checkin, checkout).days
        periodDays = Period.fieldDifference(checkin, checkout).get(DurationFieldType.days())
        period = new Period(checkin, checkout)
        log.info("Days 24-28 between dates: ${days} ${periodDays} ${period.days}")
    }
}
