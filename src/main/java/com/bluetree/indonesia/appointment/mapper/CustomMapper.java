package com.bluetree.indonesia.appointment.mapper;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.ObjectFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultConstructorObjectFactory;
import ma.glasnost.orika.metadata.TypeFactory;

import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import com.bluetree.indonesia.appointment.domain.AbstractEntity;
import com.bluetree.indonesia.appointment.dto.AbstractDto;
import com.bluetree.indonesia.appointment.dto.EntityDto;

@Component
public class CustomMapper extends ConfigurableMapper {

    @Inject
    private EntityLoader entityLoader;

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        //Reflectively register factories
        Reflections reflections = new Reflections("com.bluetree.indonesia.appointment.domain");
        Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);        
        for (Class<?> entity : entities) {
        	Inheritance inheritance = entity.getAnnotation(Inheritance.class);
        	if (inheritance == null) {
        		System.out.println("Registering Orika Object Factory for entity: " + entity.getName());
        		factory.registerObjectFactory(new Factory(entity), TypeFactory.valueOf(entity));
        	}
        }
    }

    private class Factory<T extends AbstractEntity> implements ObjectFactory<T> {

        private Class<T> clz;

        public Factory(Class<T> clz) {
            this.clz = clz;
        }

        @Override
        public T create(Object source, MappingContext mappingContext) {
            if (source instanceof AbstractDto
                    || source instanceof EntityDto) {
                Long id = null;
                if (source instanceof AbstractDto) {
                    AbstractDto dto = (AbstractDto) source;
                    id = dto.getId();
                } else {
                    EntityDto dto = (EntityDto) source;
                    id = dto.getId();
                }

                if (id != null) {
                    return entityLoader.load(clz, id);
                }
            }

            return new DefaultConstructorObjectFactory<T>(clz).create(source, mappingContext);
        }
    }
}
