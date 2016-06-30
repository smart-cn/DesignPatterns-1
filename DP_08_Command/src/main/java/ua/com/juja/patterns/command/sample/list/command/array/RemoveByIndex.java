package ua.com.juja.patterns.command.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class RemoveByIndex implements Command {

    private ArrayReceiver receiver;

    public RemoveByIndex(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Object... args) {
        if (args.length != 1 || !(args[0] instanceof Integer)) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [Integer]");
        }

        Integer index = (Integer)args[0];

        String old = receiver.get(index);
        for (int i = index + 1; i < receiver.size(); i++) {
            receiver.set(i - 1, receiver.get(i));
        }
        receiver.copyOf(receiver.size() - 1);

        return old;
    }
}
