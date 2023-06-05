Name: Electronic Component Identifier
Source: Web scraping Google Images using Google Image Scraper gotten from https://github.com/ohyicong/Google-Image-Scraper.
Description: The dataset consists of images of electronic components and serves as an identifier for various electronic parts. It is used for the Computer Vision tasks.
Features: The dataset contains images as the input data. Each image represents an electronic component.
Target Variable: The dataset is focused on identifying electronic components, the target variable are the class or label of each component in the image.
Data Format: The dataset is stored in a format suitable for image data.
Data Size: The dataset is divided into two sets:

Training Set: Contains 11,645 instances or images, which represent 70% of the total dataset.
Validation Set: Contains 4,984 instances or images, which represent 30% of the total dataset.
Total: The complete dataset consists of 16,629 instances or images.

Data Acquisition:
In the data acquisition stage, I used a Google Image scraper to gather the images for your project. The scraper consists of three parts: GoogleImageScraper.py, patch.py, and main.py. GoogleImageScraper.py is a Python script that uses Selenium library to scrape and download images from Google search results. It defines a class called GoogleImageScraper, which has methods to find image URLs and save the images. The script initializes the scraper with necessary parameters and performs the scraping and downloading.

Data Preprocessing:
After acquiring the data, you performed preprocessing using two shell scripts: ext_changer.sh and rename.sh. The ext_changer.sh script renames files with undesirable extensions (such as .webp and .gif) to more desirable extensions like .jpg and .jpeg. The rename.sh script renames the files in a directory based on a specific naming pattern, using a desired name and a sequence of numbers to differentiate them.

Model Selection:
MobileNet v2 model for your project. MobileNet v2 is a convolutional neural network architecture designed for efficient mobile and embedded vision applications. It is a pre-trained model that can be used for various image classification tasks.