import tensorflow as tf
# import bd
gpus = tf.config.experimental.list_physical_devices('GPU')
for gpu in gpus:
  tf.config.experimental.set_memory_growth(gpu, True)
max_features = 5000
max_len = 4
text_dataset = open('text1.txt', encoding='utf-8')

vectorize_layer = tf.keras.layers.TextVectorization(
 max_tokens=max_features,
 output_mode='int',
 output_sequence_length=max_len)
print(text_dataset)

vectorize_layer.adapt(text_dataset)



print(b)
