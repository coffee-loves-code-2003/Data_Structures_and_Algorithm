def max_merits(days_merit,last,day):
    if day==0:
        max_element=0
        for i in range(0,3):
            if i!=last:
                max_element=max(max_element,days_merit[day][i])
        return max_element
    max_element=0
    for i in range(0,3):
        if i!=last:
            current_element=days_merit[day][i]+max_merits(days_merit,last,day-1)
            max_element=max(max_element,current_element)
    return max_element


days_merit=[[100,10,20],[20,60,40],[10,200,30],[50,60,70]]
print(max_merits(days_merit,3,len(days_merit)-1))