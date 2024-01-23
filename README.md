## GUI Bug Localization Data

1. Download source code repositories (~4.29GB) using the following commands:

```
pip install gdown
gdown "https://drive.google.com/uc?export=download&id=1zluoAWnPLPx1nCK7WSb0EQ5ctCwwisU3"

```
2. Unzip the source code repositories file
3. Download augmented source code repositories (~1.45GB) using the following command:
```
gdown "https://drive.google.com/uc?export=download&id=1s9dpzEXdT_zEVPanhsa5rf-etEGm18xL"
```
4. Unzip the augmented source code repositories file

### Directory Structure (Dataset)
```bash
├── UI Bug Localization Dataset
│   ├──  BugLocalizationGroundTruth --> contains the ground truth for buggy commit ids and relevant filenames in JSON format for all 80 bug reports
│   ├──  BugReports --> contains bug reports in text format concating titles and contents
│   ├──  BugReportsTitles --> contains bug report titles in text format
│   ├──  BugReportsContents --> contains bug report contents excluding titles in text format
│   ├──  TraceReplayer-Data --> GUI metadata from bug reproduction scenarios having app screenshots, relevant XMLs, and app execution information in JSON format
│   ├──  Augmentation-Info --> necessary GUI information and potential filenames based on the number of screens, re-ranking criteria used in the configurations
│   ├──  Preprocessed-Data --> preprocessed queries with original content, query replacement, query expansion, and preprocessed source code 
|   |   ├── PreprocessedTitles -> preprocessed queries containing only bug report titles 
|   |   ├── PreprocessedContents -> preprocessed queries containing bug reports excluding titles 
|   |   ├── PreprocessedBugReports -> preprocessed queries containing bug reports including titles 
|   |   ├── BugLocatorQueries -> preprocessed BugLocator queries 
|   |   ├── PreprocessedCode -> preprocessed source code
```

All the bug reports that we used in our experiments are taken from the AndroR2 [1][2] dataset. The bug ids used in the filenames are the same bug ids from the AndroR2 dataset. We provide the detailed contents for each directory below.
#### BugLocalizationGroundTruth
This directory contains 80 json files with ```<bug-id>.json``` file format. Each file contains the following information:

    - id: Bug Id
    - bug_location: 
        - commit_ids: the commit id where a bug occurs
        - file_name: the file where a bug exists

#### BugReports
This directory contains 80 txt files containing bug reports containing titles and contents in ```bug_report_<bug-id>.txt``` file format. 

#### BugReportsTitles
This directory contains 80 txt files containing only bug report titles in ```bug_title_<bug-id>.txt``` file format. 

#### BugReportsContents
This directory contains 80 txt files containing only bug report contents, excluding titles in ```bug_report_<bug-id>.txt``` file format. 

#### TraceReplayer-Data
This directory contains 80 folders with ```TR<bug-id>``` file format each having the following information:

    - Execution-1.json: execution information having activities, actions, GUI component information.
    - .xml files: GUI hierarchy information for the screens that were traversed in the app
    - screenshots: app screenshots, screenshots with marked exercised GUI components and GUI component screenshots.

#### Augmentation-Info
Here, the subdirectory is designed as follows:

```bash
├── Screen (2/3/4 screens)
│   ├──  Corpus (all files or files if filtered based on GUI types): Files_In_Corpus.csv file contains bug report id and necessary file paths and Queries.csv file contains bug report ids, activities, fragments, exercised GUI components and all GUI components on the selected screens
|   |   ├── Boosting (files if boosted based on GUI types): This directory contains files that are boosted in Match_Query_File_List.csv and the remaining files are in Not_Match_Query_File_List.csv
```

_**GUI Types acronyms used in the paper and the same names in this repository:**_
- GS = GUI_States
- EGC = Interacted_GUI_Component_IDs
- GS+EGC = GUI_State_and_Interacted_GUI_Component_IDs
- SC = All_GUI_Component_IDs
- GS+SC = GUI_State_and_All_GUI_Component_IDs

### References
1. Tyler Wendland, Jingyang Sun, Junayed Mahmud, SMH Mansur, Steven Huang, Kevin Moran, Julia Rubin, and Mattia Fazzini. 2021. Andror2: A Dataset of Manually-Reproduced Bug Reports for Android apps. In MSR’21. 600–604.

2. Jack Johnson, Junayed Mahmud, Tyler Wendland, Kevin Moran, Julia Rubin, and Mattia Fazzini. 2022. An Empirical Investigation into the Reproduction of Bug Reports for Android Apps. SANER’22 (2022).

