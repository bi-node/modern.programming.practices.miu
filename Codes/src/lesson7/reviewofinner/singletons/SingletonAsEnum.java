package lesson7.reviewofinner.singletons;

/*
 * Sol 3
 * Thread safe
 * Eager initialization
 */
public enum SingletonAsEnum {
	INSTANCE;
}

//See how it works
class TestSingleton {
	static void main(String[] args) {
		SingletonAsEnum instance = SingletonAsEnum.INSTANCE;
	}
}
