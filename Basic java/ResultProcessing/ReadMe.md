<font size="4">

# Assignment 1 - Result Processing

## Instructions 
You have to write a java program to process the results of an examination. There are three categories of files:

    Student information
    Subject and paper information
    Marks obtained

Each student gives exams for three subjects—

    Math, Physics and Chemistry. 
    Math has one paper, 
    while Physics and Chemistry have two papers each. 
In each paper, there are two parts— 

    theoretical and practical.

You have to tabulate the marks and produce student wise results.

## Rules for Passing

    The student has to get at least 50% of the total marks of a portion to pass in that portion (theoretical or practical)
    The student has to pass in both portions to pass the subject
    If the subject has papers, the student has to pass in both papers
    The student has to pass in all 3 subjects to get a pass in the full exam

## File Formats

#### *All input files are CSV files,but the field separator is a ":" (colon), instead of comma.*

**Student Information**
    
    Filename: student_info.csv
    
    Format:
    
        ROLL:NAME
    Example:
    
        32:Syed Abdullah Khan
        25:Mehedi Hasan

**Paper Information**
    
    Filename: paper_info.csv
        
    Format:
        
        PAPER_CODE:NAME:PAPER_NUMBER:HAS_THEORY:HAS_PRACTICAL:THEORY_MARKS:PRACTICAL_MARKS
        
        If the subject does not have papers, PAPER_NUMBER will be 0. THEORY_MARKS and PRACTICAL_MARKS are total marks in those portions.
        
    Example:
        
        101:Math:0:T:F:100:0
        201:Physics I:1:T:T:60:40
        202:Physics II:2:T:T:60:40
        301:Chemistry I:1:T:T:70:30
        302:Chemistry II:2:T:T:70:30
        
        
**Subject-Paper Mapping**
        
    Filename: subject_paper.csv
        
        There is s one-to-many mapping between subject and papers.
        
    Format:
        
        SUBJECT_CODE:PAPER_CODE
        
        
    Example:
        
        1000:101
        2000:201
        2000:202
        3000:301
        3000:302
        
**Subject Names**
        
    Filename: subject_name.csv
        
        There is a one-to-one mapping between subject code and name.
        
    Format:
        
        SUBJECT_CODE:NAME
        
    Example:
        
        1000:Mathematics
        2000:Physics
        3000:Chemistry
        
        
**Marks Obtained**
        
    Filename: marks.csv
        
    Format:
        
        ROLL:SUBJECT_CODE:IS_THEORY:IS_PRACTICAL:MARKS
        
        
    Example:
        
        3:101:T:F:95
        3:201:T:T:50
        3:201:F:T:30
    

## Output Files
    
    After processing the input and applying the business rules, you will need to produce two files to describe the results of the students.
    
**Results File**
        
    Filename: result.csv
        
    Format:
        
        ROLL:STUDENT_NAME:TOTAL_MARKS:HAS_PASSED
        
        The HAS_PASSED field is a boolean, 'T' if the student passed, 'F' if he/she has not passed.
        
    Example:
        
        3:Nargis Akhter:400:T
        4:Sadiq Khan:200:F
    
    
**Mark Sheet**
    
    Filename: mark_sheet.csv
        
    Format:
        
        ROLL:SUBJECT_CODE:TOTAL_MARKS_IN_SUBJECT:HAS_PASSED
        
        The HAS_PASSED field is a boolean, 'T' if the student passed, 'F' if he/she has not passed.
        
    Example:
        
        3:1000:80:T
        3:2000:160:T
        3:3000:160:T
        4:1000:40:F
        4:2000:80:F
        4:2000:80:F

## How to Process

    Do not use any external libraries.
    Read the files, parse the lines, use data structures available in JDK. 
    You may want to write a few classes to hold the data and help in processing. 
    Then write the results. It's a command line program. 
    The program should not prompt to user for any input.
    You may want to print some status/debug information to standard output (System.out.println) while processing.
</font>