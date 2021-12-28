package ridev.com.br.group.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Data
@Builder
@AllArgsConstructor
public class Group {

    private final String roleName;
    private final String permission;
    private final String prefix;
    private final int priority;
    private final boolean broadcast;
    private final String nameWithColor;
    private final String roleColor;


    public Group(@NonNull String name, @NonNull String permission, @NonNull String prefix, boolean broadcast, int priority) {

        this.roleName = name;
        this.permission = permission;
        this.prefix = prefix;
        this.priority = priority;
        this.broadcast = broadcast;
        String roleColor = getFirstColor(prefix);
        this.nameWithColor = roleColor + this.roleName;
        this.roleColor = roleColor;

    }


    public void createGroup() {
        Group group = Group.builder()
                .roleName(this.roleName)
                .permission(this.permission)
                .prefix(this.prefix)
                .priority(this.priority)
                .broadcast(this.broadcast)
                .nameWithColor(this.nameWithColor)
                .roleColor(this.roleColor)
                .build();
        GroupManager.getGroups().add(group);
    }

    public static final Pattern COLOR_PATTERN = Pattern.compile("(?i)(§)[0-9A-FK-OR]");

    public static String getFirstColor(String input) {
        Matcher matcher = COLOR_PATTERN.matcher(input);
        String first = "";
        if (matcher.find()) {
            first = matcher.group();
        }

        return first;
    }
}

