Image encryption using Java. It is a simple project to encrypt and decrypt an image using the same key. 
The algo I have used here is DES DATA encryption standard. Key generator class was used to generate a secret key for both. The cipher class played an important role.

The workflow involves key generation, encryption, and decryption phases. The secret key is generated using KeyGenerator. 
During encryption, the Cipher is initialized for encryption mode, and the image file is read, encrypted, and the result is written to a new file. 
The decryption process follows a similar path, ensuring that only users with the correct key can access the original image.
