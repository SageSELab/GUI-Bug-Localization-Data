## GUI Bug Localization Data

1. Download source code repositories using the following commands:

```
pip install gdown
gdown "https://drive.google.com/uc?export=download&id=1zluoAWnPLPx1nCK7WSb0EQ5ctCwwisU3"

```
2. Unzip the source code repositories file
3. Download augmented source code repositories using the following commands:
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

_**GUI Types acronyms used in the paper and the same names in this repository:**_
- GS = GUI_States
- EGC = Interacted_GUI_Component_IDs
- GS+EGC = GUI_State_and_Interacted_GUI_Component_IDs
- SC = All_GUI_Component_IDs
- GS+SC = GUI_State_and_All_GUI_Component_IDs
