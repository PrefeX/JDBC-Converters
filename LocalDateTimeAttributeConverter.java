package no.ploge.sql.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.ejb.Stateless;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


/**
 * Implement conversion-support for {@link LocalDateTime}, so it is possible to
 * store it in the DB (as SQL-{@link Timestamp}) though the entity classes.
 *
 * @author Christian
 * @version 1.0
 * @since 1.0
 */
@Stateless
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
    }


    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime();
    }

}
