import uno.collections.queues.BoundedCircularQueue;

public class SampleDriver
{
	public static void main(String[] args)
	{
		BoundedCircularQueue<Integer> testQ = new BoundedCircularQueue<>(20);
		System.out.println("Queue should be empty: " + testQ.isEmpty());
		for (int i = 19; i >= 0; i--)
		{
			testQ.enqueue(i);
		}
		System.out.println("Queue should not be empty: " + testQ.isEmpty());
		System.out.println("Queue front should be 19: " + testQ.peek());
		System.out.println("Queue size should be 20: " + testQ.size());
		System.out.println("Values in descending order:");
		
		while (!testQ.isEmpty())
		{
			int val = testQ.dequeue();
			System.out.println(val);
		}
	}
}
