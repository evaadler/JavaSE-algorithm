public class 堆排序 {


    public static void upAdjust(int[] array)

    {

        int childIndex = array.length - 1;

        int parentIndex
                =
                childIndex
                        /
                        2;

// temp保存插入的叶子节点值，用于最后的赋值

        int
                temp
                =
                array
                        [
                        childIndex
                        ];

        while

                (
                childIndex
                        >

                        0

                        &&
                        temp
                                <
                                array
                                        [
                                        parentIndex
                                        ])

        {

//无需真正交换，单向赋值即可
            array
                    [
                    childIndex
                    ]

                    =
                    array
                            [
                            parentIndex
                            ];
            childIndex
                    =
                    parentIndex
            ;
            parentIndex
                    =
                    parentIndex
                            /

                            2
            ;

        }
        array
                [
                childIndex
                ]

                =
                temp
        ;
    }
}
