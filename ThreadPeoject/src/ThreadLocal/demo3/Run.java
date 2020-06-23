package ThreadLocal.demo3;

/**
 * 解决默认 get（） 返回null问题
 */
public class Run {
	public static ThreadLocalExt tl = new ThreadLocalExt();

	public static void main(String[] args) {
		if (tl.get() == null) {
			System.out.println("从未放过值");
			tl.set("我的值");
		}
		System.out.println(tl.get());
		System.out.println(tl.get());
	}

}
