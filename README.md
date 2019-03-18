java.util.stream

    流API中的流操作的数据源，是数组或者是集合，它本身是不存储数据的，只是移动数据，在移动过程中可能会对数据进行过滤、排序或者其它操作。绝大多数情况下，流操作本身不会修改数据源。

    终端操作和中间操作
    
        终端操作：会消费流，这种操作会产生一个结果，比如min()和max()。一个流被消费过了，那它就不能被重用了。
        
        中间操作：中间操作产生另一个流。中间操作不是立即发生的，相反，当在中间操作创建的新流上执行完终端操作后，中间操作制定的操作才会发生。所以中间操作是延迟发生的，
        中间操作的延迟行为主要是让流API能够更加高效地执行。
        
            无状态操作：在处理流中的元素时，会对当前的元素进行单独处理。比如：谓词过滤操作
            有状态操作：某个元素的处理可能依赖于其他元素。比如：最大值、最小值和排序
        
    BaseStream
        Iterator<T> iterator();
            获得流的迭代器，并返回对该迭代器的引用（终端操作）
            
        Spliterator<T> spliterator();
            获取流的spliterator，并返回其引用（终端操作）
            
        boolean isParallel();
            如果调用流是一个并行流，则返回true;如果调用流是一个顺序流，则返回false（终端操作）
            
        S sequential();
            基于调用流，返回一个顺序流。如果调用流已经是顺序流了，就返回该流（中间操作）
            
        S parallel();
            基于调用流，返回一个并行流。如果调用流已经是一个并行流，就返回该流（中间操作）
            
        S unordered();
            基于调用流，返回一个无序流。如果调用流已经是无序流了，就返回该流（中间操作）
            
        S onClose(Runnable closeHandler);
            返回一个新流，closeHandler指定了该流的关闭处理程序，当关闭该流时，将调用这个处理程序（中间操作）
            
        void close();
            从AutoCloseable继承过来的，调用注册关闭处理程序，关闭调用流（几乎不用）
            
    Stream
        Stream filter(Predicate predicate);
            产生一个新流，其中包含调用流中满足predicate指定的谓词元素（中间操作）
            
        Stream map(Function mapper); 
            产生一个新流，对调用流中的元素应用mapper，新流中包含这些元素（中间操作）
            
        IntStream mapToInt(ToIntFunction mapper);
            对调用流中元素应用mapper，产生包含这些元素的一个新IntStream流（中间操作）
            
        Stream sorted(); 
        Stream sorted(Comparator comparator); 
            产生一个自然顺序排序或者指定排序条件的新流（中间操作）
            
        void forEach(Consumer action); 
        void forEachOrdered(Consumer action); 
            遍历流中的元素（终端操作）
            
        Optional min(Comparator comparator)
        Optional max(Comparator comparator);
            获得流中最大最小值，比较器可以自定义，也可以使用JDK提供的（终端操作）
            
         
    缩减操作
        每个缩减操作都把一个流缩减为一个值。比如最大值、最小值
         T reduce(T identity, BinaryOperator<T> accumulator);
         Optional<T> reduce(BinaryOperator<T> accumulator);
         <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
        
        缩减操作的三个约束
        1、无状态：  每个元素都被单独地处理
        2、不干预：  操作数不会改变数据源
        3、关联性：  给定一个关联运算符，在一些列操作中使用该运算符，先处理哪一对操作是无关紧要的。比如，（1*2）*3 == 1*（2*3）
        
    并行流
        BaseStream.parallel()
        Collection.parallelStream()
        
        一般来说，应用到并行流的任何操作都必须是符合缩减操作的三个约束条件。
        注意：如果集合中或者数组中的元素是有序的，那么对应的流也是有序的。但是在使用并行流时，有时候流是无序的就能获得性能上的提升。
        
     映射
     常见使用场景：
        1、把一个流中的元素弄到另一个流里面
        2、把流中的一些满足条件的元素放到新流里面
        3、对流中的元素应用一些转换，然后把转换的元素映射到一个新流里面
     
     <R> Stream<R> map(Function<? super T, ? extends R> mapper);
     <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        flatMap()操作能把原始流中的元素进行一对多的转换，并且将新生成的元素全部合并到它返回的流里面。
        
    收集
        从流中收集起一些元素，并以集合的方式返回。
        
    <R> R collect(Supplier<R> supplier,
                      BiConsumer<R, ? super T> accumulator,
                      BiConsumer<R, R> combiner);
                      
    <R, A> R collect(Collector<? super T, A, R> collector);
    
    流与迭代器
        BaseStream
            Iterator<T> iterator();
            Spliterator<T> spliterator();
                Spliterator支持并行迭代
            
            