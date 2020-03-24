package com.PlaygroundLibrary;

import java.util.*;

abstract public class PlaySite implements Utilization
{
    private int limit;
    private int currentAmountOfKids;
    /*
    I am creating 3 types of containers
    1. Array to store kids in the playsite;
    2. ArrayDeque to check which slots are empty in the array;
    3. ArrayList for kids in queue
     */
    Deque<Integer> emptySlotsDeque = new ArrayDeque<Integer>();
    public Kid[] kidsInPlaySiteArray;
    public List<Kid> kidsInQueueArrayList = new ArrayList<Kid>();

    public PlaySite(int limit)
    {
        this.limit = limit;
        currentAmountOfKids = 0;
        kidsInPlaySiteArray = new Kid[limit];
        for(int i = 0; i < limit; i++)
        {
            emptySlotsDeque.addLast(i);
        }
    }

    public String addKid(Kid kid)
    {
        String message = "";
        KidManager.totalKidsInPlayground.add(kid);
        if(!emptySlotsDeque.isEmpty()) {

            int arrayPosition = emptySlotsDeque.getFirst(); //get position
            kid.setCurrentPlaySite(this.typeOfPlaysite()); //let kid know where he plays
            kid.tellTimeSpent();//Just to start the timer

            kidsInPlaySiteArray[arrayPosition] = kid; //assign kid in correct position in array
            emptySlotsDeque.removeFirst(); //remove available position

            message = "Kid added to the play site";
            currentAmountOfKids++;
        }
        else
        {
            Random random = new Random();
            boolean willKidAcceptQueue = random.nextBoolean();
            if(willKidAcceptQueue) {
                kidsInQueueArrayList.add(kid); //adding kid in the queue at the end
                message = "Kid accepted being in a queue";
            }
            else { message = "Kid did not accept being in a queue"; }

            //Sort vip if kid accepted being in a queue and is a VIP
            if(message != "Kid did not accept being in a queue") {
                if (kid.isTicketTypeVIP()) {
                    sortVIPQueue(kid);
                }
            }
        }

        return message;
    }
    public String showQueuedKids()
    {
        String queue = "";
        for(Kid queuedKid : kidsInQueueArrayList)
        {
            if(queuedKid.isTicketTypeVIP()) { queue += "V"; }
            else {queue += "N"; }
        }
        System.out.println(queue);
        return queue;
    }
    public void removeKidFromPlaySite(int position)
    {
        kidsInPlaySiteArray[position] = null; //remove kid from array
        if(currentAmountOfKids > 0) { //so counter wouldn't be less than 0
            currentAmountOfKids--;
        }
        if(!kidsInQueueArrayList.isEmpty()) //if queue not empty
        {
            kidsInPlaySiteArray[position] = kidsInQueueArrayList.get(position);//add recent kid from queue
            removeKidFromQueue(position);
            currentAmountOfKids++; //Readded kids amount
        }
        else { emptySlotsDeque.addFirst(position); }//create a new empty slot
    }
    public void removeKidFromQueue(int position)
    {
        kidsInQueueArrayList.remove(position);
    }
    public void sortVIPQueue(Kid kidVIP)
    {
        Kid kid;
        int size = kidsInQueueArrayList.size();

        //We are going backwards, searching for the last vip
        for(int j = size - 1; j >= 0; j--)
        {
            //While being in j position, lets get last position before j
            //to determine if that position, not current, is VIP
            int previousSlot = j - 1;
            //to avoid previousSlot being -1 and continuing to access it in arraylist
            if(j > 0) {
                kid = kidsInQueueArrayList.get(previousSlot);
                if (kid.isTicketTypeVIP())//if we found VIP
                {
                    //Search for difference to be more that 4, because we will put VIPs only between 3 normal
                    //kids, if difference is going to be less than 4, just keep the VIP in the same place
                    int difference = size - j;
                    if (difference > 4) {
                        //Place just further back by 4 places
                        kidsInQueueArrayList.add(previousSlot + 4, kidVIP);
                        //remove that vip kid, it already is placed closer in queue to avoid dublication
                        kidsInQueueArrayList.remove(kidsInQueueArrayList.size() - 1);
                    }
                    //Once VIP is found, we no longer need to continue searching for older VIPs
                    //so break from the loop
                    break;
                }
            }
            //If no vip found, just add one at the start
            //but after normal kids if they are already sorted
            else if(j == 0)
            {
                if(!kidsInQueueArrayList.get(j).isTicketTypeVIP()) {
                    kidsInQueueArrayList.add(j, kidVIP);
                    //remove that vip kid, it already is placed closer in queue to avoid dublication
                    kidsInQueueArrayList.remove(kidsInQueueArrayList.size() - 1);
                }
            }
        }
    }

    public int getLimit() {
        return limit;
    }

    public int getCurrentAmountOfKids() {
        return currentAmountOfKids;
    }

    abstract public String typeOfPlaysite();
}
