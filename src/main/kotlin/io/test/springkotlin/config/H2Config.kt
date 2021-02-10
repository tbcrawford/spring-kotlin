package io.test.springkotlin.config

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import javax.sql.DataSource

@Configuration
@MapperScan(basePackages = ["io.test.springkotlin.dao"], sqlSessionFactoryRef = "sqlSessionFactory")
class H2Config {

    @Bean
    fun dataSource(): DataSource {
        return EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("schema.sql")
            .build()
    }

    @Bean
    fun sqlSessionFactory(dataSource: DataSource): SqlSessionFactory {
        val bean = SqlSessionFactoryBean()
        bean.setDataSource(dataSource)
        bean.setMapperLocations(*PathMatchingResourcePatternResolver().getResources("classpath*:dao/*.xml"))
        return bean.`object`!!
    }

}