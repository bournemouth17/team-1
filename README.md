# Team-1 - RNLI App

## Medical Assessment

### DR ABCDE Assessment
- Replicates the flow diagram shown in the booklet and allows the user to follow through the steps.
- It also provides timers for multiple measurements such as CCR (Central Capillary Refil) and breaths in 10 seconds.

### Assessment Suggestions
- The measurements and answer taken in this set of yes no questions are then used to suggest a likely symptom that can be acted on.
  - A planned extension of this was to use diagnosis answers to filter and prioritise cards that are more likely to be relevant by moving them to the top of the lists.
- The diagnosis is not intended to replace the users judgement or decision makig ability. It is more intended as a prompt/reminder to the user.

## Medical Reporting
- Report for the first responders that will meet with the RNLI is generated with the information collected in the assessments but also with data inputted by the RNLI staff.
  - Given the time and resources the reporting system would be extended to interface with the first responders' existing system.

## External Database Connection (Unfortunatly did not interface well with android)
- All of the aformentioned medical data that will be recorded will then be uploaded to the SQL database which can then be accessed by admins and other autherised personnel back at base. 
  - This data could then be distributed to the relevant personnel and could help with treatment when the victim arrives at a medical facility. 
