package radioAlarm;


import lombok.experimental.Delegate;

public class RadioAlarm implements Radio, Alarm {
    // Добавляет вызовы методов из классов-реализаций интерфейсов, которые мы тут имплементируем
    // Эта задача - пример композиции
    @Delegate
    private Radio radio = new RadioFunctionality();
    @Delegate
    private Alarm alarm = new AlarmFunctionality();

}
