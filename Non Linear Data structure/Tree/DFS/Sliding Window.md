l=0 r=0 sum=0
maxlen=0
while(r<n>
{
    sum=sum+arr[r];
    if(sum<=k)
    {
        maxlen=max(maxlen,r-l+1);
    }
    else
    {
        while(l<=r && sum>k)
        {
            sum=sum-arr[l]
            l++;
        }
    }
    r++
})
print(maxlen)