package list.arraylist;

public interface IArrayList {

    /**
     * 容量
     * @return
     */
    int caparity();

    /**
     * 实际大小
     * @return
     */
    int size();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();


    /**
     * 加入 末尾加入
     */
    void add(int element);

    /**
     * 加入 中间插入
     * @param index
     * @param element
     */
    void add(int index, int element);

    /**
     * 查找
     * @param element
     * @return
     */
    boolean contains(int element);

    /**
     * 查找
     * @param index
     * @return
     */
    int get(int index);

    /**
     * 修改元素
     * @param index
     * @param element
     */
    void set(int index, int element);

    /**
     * 删除index元素
     * @param index
     * @return
     */
    int remove(int index);

    /**
     * 根据element删除元素
     * @param element
     * @return
     */
    int removeElement(int element);

    void print();

    /**
     * 改变capacity大小
     */
    void resize(int capacity);


}
