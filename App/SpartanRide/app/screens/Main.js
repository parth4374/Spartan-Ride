import React from 'react'
import {
  Button,
  Text
} from 'react-native'

export const Main = ({ navigation, route }) => {
  return <>
   <Text>Welcome {route.params.name}</Text>
   <Button
        title="Back to Login"
        onPress={() =>
          navigation.navigate('Login')
        }
      />
   </>
}
