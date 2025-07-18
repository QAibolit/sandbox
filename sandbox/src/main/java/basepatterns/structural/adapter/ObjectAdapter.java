package basepatterns.structural.adapter;

/**
 * <h3>Адаптер</h3>
 * <br><b>Паттерн Адаптер</b> позволяет работать с несовместимыми интерфейсами,
 * преобразуя интерфейс одного класса в интерфейс, ожидаемый клиентом.
 * <br>
 * <br><b>Когда использовать паттерн Адаптер:</b>
 * <br>&emsp;- Когда нужно использовать существующий класс,
 * но его интерфейс не соответствует вашим потребностям.
 * <br>&emsp;- Интеграция сторонних библиотек (например, работа с разными API).
 * <br>&emsp;- Когда вы хотите создать повторно используемый класс,
 * который сотрудничает с классами, имеющими несовместимые интерфейсы
 * <br>&emsp;- Когда вам нужно использовать несколько существующих подклассов,
 * но невозможно адаптировать их интерфейсы путем наследования от каждого
 * <br>&emsp;- Работа с устаревшим кодом, который нельзя изменить.
 * <br>&emsp;- Унификация интерфейсов (например, разные реализации хранилищ данных).
 * <br>
 * <br><b>Основные варианты реализации:</b>
 * <br>&emsp;- Объектный адаптер (использует композицию) - более гибкий
 * <br>&emsp;- Классовый адаптер (использует наследование) - требует
 * множественного наследования (в Java можно через интерфейсы)
 * <br>
 * <br><b>Преимущества:</b>
 * <br>&emsp;- Совместимость несовместимых интерфейсов. Позволяет
 * интегрировать старый или сторонний код, не меняя его исходников.
 * Пример: адаптация вызовов к старой библиотеке под новый интерфейс.
 * <br>&emsp;- Гибкость и переиспользование кода. Можно использовать
 * существующие классы, даже если их API не соответствует требованиям.
 * <br>&emsp;- Отделяет клиентский код от конкретных реализаций. Клиент
 * работает с целевым интерфейсом, не зная деталей адаптируемого объекта.
 * <br>&emsp;- Поддержка Open/Closed Principle. Можно добавлять
 * новые адаптеры, не изменяя существующий код.
 * <br>&emsp;- Работа с legacy-кодом. Позволяет постепенно модернизировать
 * систему, не ломая старую функциональность.
 * <br>
 * <br><b>Недостатки:</b>
 * <br>&emsp;- Усложнение кода. Появляются дополнительные классы (адаптеры),
 * что увеличивает сложность системы.
 * <br>&emsp;- Накладные расходы на преобразование. Адаптер может
 * добавлять небольшую задержку из-за дополнительного слоя.
 * <br>&emsp;- Не всегда очевиден выбор между адаптером и рефакторингом. Иногда
 * проще изменить исходный код, чем писать адаптер.
 * <br>&emsp;- Может маскировать проблемы дизайна. Если интерфейсы сильно
 * несовместимы, возможно, стоит пересмотреть архитектуру.
 * <br>&emsp;- Ограничения при множественном наследовании (для классовых адаптеров).
 * В Java нельзя наследовать несколько классов, поэтому объектный адаптер (композиция)
 * чаще предпочтительнее.
 */
public class ObjectAdapter {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter("mp4");
        player.play("mp4", "movie.mp4");

        player = new MediaAdapter("vlc");
        player.play("vlc", "song.vlc");
    }
}

// Целевой интерфейс, который ожидает клиент
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Адаптируемый класс с несовместимым интерфейсом
class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

// Адаптер, преобразующий интерфейс AdvancedMediaPlayer в MediaPlayer
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new AdvancedMediaPlayer();
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new AdvancedMediaPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}