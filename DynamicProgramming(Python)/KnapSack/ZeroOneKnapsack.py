def find_result(wt,values,given_weight,index_wt):
    if given_weight<=0:
        return 0
    if index_wt==0 and given_weight-wt[index_wt]>=0:
        return values[index_wt]
    if index_wt<0:
        return 0
    take=-99999999
    if given_weight-wt[index_wt]>=0:
        take= values[index_wt]+find_result(wt,values,given_weight-wt[index_wt],index_wt-1)
    not_take=find_result(wt,values,given_weight,index_wt-1)
    return max(take,not_take)

wt=[1,2,4,5]
values=[5,4,8,6]
print(find_result(wt,values,5,len(wt)-1))