# KPO_RestaurantHW
Домашнее задание 2
При запуске система спрошивает, кем является пользователь: если это админ, он должен ввести пароль(qwerty), у посетителей ничего не спрашивается. Для хранения пароля используется хеширование.

Администратор может посмотреть меню( команда menu), добавить блюдо в меню( команда add), удалить блюдо из меню( команда сетитель может ), изменить пароль( команда change) и редактировать информацию о блюде( время приготовления/количество/цену, команда edit).

Посетитель может посмотреть меню, сделать заказ, оплатить заказ и при желании оставить отзыв.

Чтобы завершить программу нужно ввести команду "exit".

Заказы обрабатываются в многопоточном режиме. Чем раньше был сделан заказ, тем выше у него приоритет.

Для сохранения состояния программы (меню, суммы выручки и пользователей) используется паттерн Memento.

Система отображает статус заказа: "accepted", "cooking in process" и "cooked". После оплаты статус становится "payed".

Menu - синглетон, это нужно для того, чтобы в системе не могло существовать несколько меню одновременно.
