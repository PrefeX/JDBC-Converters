package no.ploge.sql.converter;

import java.sql.Date;
import java.time.LocalDate;
import javax.ejb.Stateless;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


/**
 * Implement conversion-support for {@link LocalDate}, so it is possible to
 * store it in the DB (as SQL-{@link Date}) though the entity classes.
 *
 * @author Christian
 * @version 1.0
 * @since 1.0
 */
@Stateless
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return localDate == null ? null : Date.valueOf(localDate);
    }


    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return sqlDate == null ? null : sqlDate.toLocalDate();
    }

}
