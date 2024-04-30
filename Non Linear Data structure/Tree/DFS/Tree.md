Number of nodes=3
tree node from = [1,2]
tree node to =[2,3]
and the weight assosiated with the edge = [10,20]



                    1
                   / 
                  /  (10)
                 2
                /
               /  (20)
              /
             3 



             total weight =30



number of nodes =4
tree node from =[1,2,2]
tree node to =[2,3,4]
weight assosiated with the edge  =[ 10,20,30]


                        1
                        |
                        |
                        |  (10)
                        |
                        |
                        2
                       /  \
                     /      \
       (20)         /         \     (30)
                   /            \
                  3               4  


                total_weight=0
                1->2                =10+Math.ceil(1/2)=11
                2->3 && 3->2        =20+Math.ceil(2/2)=21
                2-> 4               =30+Math.ceil(1/2)=31

                Total weight = 11+21+31

        
    