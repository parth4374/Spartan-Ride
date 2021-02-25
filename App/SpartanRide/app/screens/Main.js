import React from 'react'
import {
  Button,
  Text
} from 'react-native'

export const Main = ({ navigation, route }) => {
  return <>
   <Text>This is going to be the main screen</Text>
   <Button
        title="Back to Login"
        onPress={() =>
          navigation.navigate('Login')
        }
      />
   </>
}
