package hibernate5.demo.event.CustomPhysicalNamingStrategy;

import java.util.*;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.apache.commons.lang3.StringUtils;

/**
 * To use the CustomPhysicalNamingStrategy, we need configure it in "persistence.xml"
 * @author Duan
 */
public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {
    private static final Map<String, String> ABBREVIATIONS = buildAbbreviationMap();

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) { // Acme naming standards do not apply to catalog names
        return name;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) { // Acme naming standards do not apply to schema names
        return null;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        final List<String> parts = splitAndReplace(name.getText());
        return jdbcEnvironment.getIdentifierHelper().toIdentifier(
                join(parts), name.isQuoted()
        );
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        final LinkedList<String> parts = splitAndReplace(name.getText());
        if (!"seq".equalsIgnoreCase(parts.getLast())) {
            parts.add("seq");
        }
        return jdbcEnvironment.getIdentifierHelper().toIdentifier(
                join(parts), name.isQuoted()
        );
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        final List<String> parts = splitAndReplace(name.getText());
        return jdbcEnvironment.getIdentifierHelper().toIdentifier(
                join(parts), name.isQuoted()
        );
    }

    private static Map<String, String> buildAbbreviationMap() {
        TreeMap<String, String> abbreviationMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        abbreviationMap.put("account", "acct");
        abbreviationMap.put("number", "num");
        return abbreviationMap;
    }

    private LinkedList<String> splitAndReplace(String name) {
        LinkedList<String> result = new LinkedList<>();
        for (String part : StringUtils.splitByCharacterTypeCamelCase(name)) {
            if (part == null || part.trim().isEmpty()) { // skip null and space
                continue;
            }
            part = applyAbbreviationReplacement(part);
            result.add(part.toLowerCase(Locale.ROOT));
        }
        return result;
    }

    private String applyAbbreviationReplacement(String word) {
        if (ABBREVIATIONS.containsKey(word)) {
            return ABBREVIATIONS.get(word);
        }
        return word;
    }

    private String join(List<String> parts) {
        boolean firstPass = true;
        String separator = "";
        StringBuilder joined = new StringBuilder();
        for (String part : parts) {
            joined.append(separator).append(part);
            if (firstPass) {
                firstPass = false;
                separator = "_";
            }
        }
        return joined.toString();
    }
}

