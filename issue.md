

### issue 1

在@Entity 注解的数据实体时谨慎使用 lombok 的 @Data,虽然它很方便，能自动帮你生成许多setter/getter代码，但是搞清楚其中的原理至关重要

以下是关于@Data的解释

@Data is like having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor annotations 
on the class (except that no constructor will be generated if any explicitly written constructor exists).

如果你碰到以下这样类似的错误:
java.lang.NullPointerException: null
	at com.huayutech.web.domain.product.Product.hashCode(Product.java:42) ~[classes/:na]
	at com.huayutech.web.domain.product.ProductImage.hashCode(ProductImage.java:11) ~[classes/:na]
	
那么一般是@Data 通过@EqualsAndHashCode为你生成 hashCode()重载除了问题，尤其是在你设置两个实体的双向关系（例如一对多，多对多）时。
那么最好的做法是够用就好，如果你只是希望让lombok 为你生成setter/getter，那么就只要加@getter @setter就好，如果你一定要用@Data注解，如果
你碰到这种情况，自己动手写一个hashCode()


### issue 2 

如何避免在生成json的时候两个实体间的关系引起循环引用的问题

使用@JsonManagedReference 和 @JsonBackReference