#include <bits/stdc++.h>
using namespace std;
int main() {
    int lengthOfQueue;
    string supporters;
    cin>>lengthOfQueue>>supporters;
    //we have to do a bfs for all A and store when A and B are reaching a particular point
    vector<pair<int,int>> checker(lengthOfQueue,{INT_MAX,INT_MAX});
    for(int i=0;i<lengthOfQueue;i++)
    {
        //see if we got A/B
        if(supporters[i]=='A')
        {
            int t=0;    //A moves towards the left
            int j=i-1;
            if(j>=0)
            {
                for(j;j>=0;j--)
                {
                    if(supporters[j]=='-')
                    {
                        checker[j].first=min(checker[j].first,t);
                    }
                    else if(supporters[j]=='A'||supporters[j]=='B')
                    {
                        break;
                    }
                    ++t;
                }
            }
        }
        else if(supporters[i]=='B')
        {//B moves towards the right
            int t=0;
            int j=i+1;
            if(j<lengthOfQueue)
            {
                for(j;j<lengthOfQueue;j++)
                {
                    if(supporters[j]=='-')
                    {
                        checker[j].second = min(checker[j].second,t);
                    }
                    else if(supporters[j]=='B'||supporters[j]=='A')
                    {
                        break;
                    }
                    t++;
                }
            }
        }
    }
    int a_count=0;
    int b_count=0;
    //we got our checker array filled
    for(int i=0;i<lengthOfQueue;i++)
    {
        int x = checker[i].first;
        int y = checker[i].second;
        if(supporters[i]=='A')
        {
            a_count++;
        }
        else if(supporters[i]=='B')
        {
            b_count++;
        }
        if(supporters[i]=='-')
        {
            //we need to check checker
            if(x>y)
            {
                //this means y reached earlier
                b_count++;
            }
            else if(x<y)
            {
                a_count++;
            }
        }
    }
    //cout<<a_count<<" "<<b_count<<" ";
    if(a_count>b_count)
    {
        cout<<"A";
    }
    else if(b_count>a_count)
    {
        cout<<"B";
    }
    else
    {
        cout<<"Coalition government";
    }
}